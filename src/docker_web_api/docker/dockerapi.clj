(ns docker-web-api.docker.dockerapi
  (:require [contajners.core :as c]))


(def docker
  (c/client {:engine   :docker
             :category :containers
             :version  "v1.41"
             :conn     {:uri "unix:///var/run/docker.sock"}}))

(defn container-start [id]
  (c/invoke docker {:op     :ContainerStart
                    :params {:id id}}))

(container-start "1705e1c733f4") ; start exist container (traefik)

(container-start "ad78aa00b794") ; start exist container (jenkins)
