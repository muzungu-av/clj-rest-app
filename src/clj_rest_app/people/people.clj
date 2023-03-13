(ns clj-rest-app.people.people
  (:require [clojure.string :as str]))

(def collection (atom []))

(defn addperson [firstname surname]
  (swap! collection conj {:firstname (str/capitalize firstname) :surname (str/capitalize surname)}))

(addperson "Functional" "Human")
(addperson "Micky" "Mouse")