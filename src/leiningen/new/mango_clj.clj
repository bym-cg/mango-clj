(ns leiningen.new.mango-clj
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "mango-clj"))

(defn mango-clj
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' mango-clj project.")
    (->files data
             ["Dockerfile" (render "Dockerfile" data)]
             ["package.json" (render "package.json" data)]
             ["app.json" (render "app.json" data)]
             ["index.js" (render "index.js" data)]
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)]
             ["deps.edn" (render "deps.edn" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/dev/user.clj" (render "user.clj" data)]
             ["src/main/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/main/{{sanitized}}/client.cljc" (render "client.cljc" data)])))



