(ns http-ex.core
	(:require [org.httpkit.client :as http]
			  [clojure.data.json :refer [read-str]]))


(defn get-comic []
	(let [response (http/get "http://xkcd.com/info.0.json")
		  data (read-str (:body @response) :key-fn keyword)]
	  (:img data)
	  )
)


(defn -main []
	(println (get-comic)))