#_(ns user
  (:require [hawk.core :as hawk]
            [clojure.java.io :as io]
            [clojure.tools.namespace.repl :as repl]))


#_(repl/set-refresh-dirs (io/file "src/calculator"))

#_(hawk/watch! [{:paths ["src/calculator"]
               :handler (fn [ctx e]
                          (#_future
                            (repl/refresh)))}])


