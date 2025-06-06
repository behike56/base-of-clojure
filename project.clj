(defproject base-of-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/data.csv "1.0.0"]]
  :main base-of-clojure.core
  :resource-paths ["resources"]
  :repl-options {:init-ns base-of-clojure.core}
  :profiles {:dev
             {:dependencies [[lambdaisland/kaocha "1.91.1392"]]
              :kaocha {:reporter :progress}}}
  :aliases {"kaocha" ["run" "-m" "kaocha.runner"]})
