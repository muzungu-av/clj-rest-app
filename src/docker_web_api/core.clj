(ns docker_web_api.core
  (:require [docker-web-api.docker.dockerapi :refer [docker]]
            [docker-web-api.people.people :as people :refer [collection]]
            [clojure.data.json :as json]
            [clojure.pprint :as pp]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [org.httpkit.server :as server]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]])
  (:gen-class))

; Simple Body Page
(defn simple-body-page [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello World"})

(defn hello-name [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (->
             (pp/pprint req)
             (str "Hello " (:name (:params req))))})

(defn people-handler [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (str (json/write-str @people/collection))})

(defroutes app-routes
  (GET "/" [] simple-body-page)
  (GET "/hello" [] hello-name)
  (GET "/people" [] people-handler)
  (route/not-found "Error, page not found!"))

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    ; параметры и куки тут включены это обеспечивается Ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))




