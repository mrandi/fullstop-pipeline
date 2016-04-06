(ns fullstop-pipeline.steps
  (:require [lambdacd.steps.shell :as shell]))
(ns fullstop-pipeline.steps
  (:require [lambdacd.steps.shell :as shell]
            [lambdacd.steps.git :as git]))

(def repo-uri "https://github.com/zalando-stups/fullstop.git")
(def repo-branch "master")

(defn wait-for-repo [args ctx]
  (git/wait-for-git ctx repo-uri repo-branch))

(defn with-repo [& steps]
  (git/with-git repo-uri steps))

(defn run-build [args ctx]
  (shell/bash ctx (:cwd args) "/usr/local/bin/mvn clean install"))
