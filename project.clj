(defproject docker_web_api "0.1.0-SNAPSHOT"
  :description "This application manages docker containers through the web interface (or rest api)"
  :url "https://github.com/muzungu-av/docker-web-api"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [compojure "1.7.0"]
                 [http-kit "2.6.0"] [ring/ring-defaults "0.3.4"]
                 [org.clojure/data.json "2.4.0"]
                 [org.clojars.lispyclouds/contajners "1.0.0"]]
  :main ^:skip-aot docker_web_api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
