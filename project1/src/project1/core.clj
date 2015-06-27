(ns project1.core
  (:require [project1.handlers :as handlers]))

;;first function 
(comment (defn example-handler [request]
           {:body "Hello Clojure and Java its relaoded!"}))

;;an example of destructuring and only obtaining the uri
(comment (defn example-handler [{:keys [:uri] :as req}]
           {:body (str "The URI is: " uri)}))

;;What values is passes in the request parameter, lets check this out.
(comment (defn example-handler [req]
  {:body (pr-str req)}))

;;accessing a text file and displaying it on the web
(comment (defn example-handler [{:keys [:uri] :as req}]
           {:body (java.io.File. "test.txt")}))
                                        ;Throwing a server error with 500

(comment (defn example-handler [{:keys [:uri] :as req}]
  {:body (java.io.File. "test.txt")
   :status 500}))

;;using headers for redirection
(defn example-handler [request]
  {:headers {"Location" "http://github.com/ring-clojure/ring"
          "Set-cookie" "test=1"}
   :status 301})

(comment (defn test1-handler [request]
           {:body "Your calling Test1!"}))

;;working with wxceptions
(defn test1-handler [request]
  (throw (RuntimeException. "error!"))
  {:body "Your calling Test1!"})
(defn test2-handler[request]
  {:status 301
   :headers {"Location" "https://play.google.com/music/listen#/ap/auto-playlist-promo"}})

(defn route-handler [request]
  (condp =(:uri request)
    "/test1" (test1-handler request)
    "/test2" (test2-handler request)
    "/test3" (handlers/handler3 request)
    nil))

(defn wrapping-handler[request]
  (try
  (if-let [resp (route-handler request)]
    resp
    {:status 404
     :body (str "Not found: " (:uri request))})
  (catch Throwable e
    {:status 500 :body (apply str (interpose "\n" (.getStackTrace e)))})))

(defn on-init[]
  (println "Initializing your lovely app"))

(defn on-destroy[]
  (println "destorying your app"))
