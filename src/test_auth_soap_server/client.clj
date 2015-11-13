(ns test-auth-soap-server.client)

(defn new []
  (gov.example.registration.RegistrationService.))

(defn login [reg-svc username password]
  (.loginUser (.getRegistrationPort reg-svc) username password))
