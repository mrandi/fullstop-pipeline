(ns fullstop-pipeline.pipeline
  (:use [lambdacd.steps.control-flow]
        [fullstop-pipeline.steps])
  (:require
    [lambdacd.steps.manualtrigger :as manualtrigger]))

(def pipeline-def
  `(
     (either
       manualtrigger/wait-for-manual-trigger
       wait-for-repo)
     (with-repo
       run-build)))
