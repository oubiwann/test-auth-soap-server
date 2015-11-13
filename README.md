# test-auth-soap-server

A Small SOAP Server for Testing Purposes

## Download

```bash
$ git clone https://github.com/oubiwann/test-auth-soap-server.git
```

## Build

1. Ensure the interface is as you want it in ``src/*/*.clj``.
1. Run ``lein run`` to start serving on localhost:8888.
1. Generate the class files:
```bash
$ wsimport \
  -d target/base+system+user+dev/classes/ \
  "http://localhost:8888/RegistrationService?wsdl"
```

## Usage

Sample usage in REPL (while ``lein run`` is still serving on localhost:8888):

```bash
$ lein repl
```
```clojure
t.c=> (def reg-service (gov.example.registration.RegistrationService.))
#'test-auth-soap-server.core/reg-service
t.c=> (def reg-proxy (.getRegistrationPort reg-service))
#'test-auth-soap-server.core/reg-proxy
t.c=> (.loginUser reg-proxy "alice" "asecret")
"OK"
```

Or you could use the Clojure wrapper provided in
``test-auth-soap-server.client``:

```clojure
t.c=> (require '[test-auth-soap-server.client :as client])
nil
t.c=> (-> (client/new)
                                 (client/login "bob" "abc123"))
"OK"
```
