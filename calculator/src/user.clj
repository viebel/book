(ns user
  (:require [hawk.core :as hawk]
            [clojure.java.io :as io]
            [clojure.tools.namespace.repl :as repl]))

(defn foo-p  []
  (print "hello user"))

(print "hello user")

(repl/set-refresh-dirs (io/file "src/calculator"))

(hawk/watch! [{:paths ["src/calculator"]
               :handler (fn [ctx e]
                          (#_future
                            (repl/refresh)))}])


