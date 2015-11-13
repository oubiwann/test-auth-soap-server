(ns test-auth-soap-server.core
  (:import (javax.jws WebMethod WebService WebParam)
           (javax.xml.ws Endpoint))
  (:gen-class))

(defprotocol Registrator (loginUser [this username password]))

(deftype ^{WebService {:targetNamespace "registration.example.gov"}}
  Registration []
  Registrator (^{WebMethod []} loginUser [this username password]
    "OK"))

(defn -main
  [& args]
  (Endpoint/publish "http://localhost:8888/RegistrationService"
                    (Registration.)))
