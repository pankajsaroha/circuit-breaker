# Circuit Breaker
## Description
Circuit Breaker Pattern allows a microservice to continue operating when a related service fails, preventing the failure from cascading and giving the falling service time to recover.

## Stages
![image](https://github.com/user-attachments/assets/2208c9e1-026c-4903-8a0a-98679fdfe56f)

### Closed
Closed is the initial state of circuit breaker. When microservices run and interact smoothly, circuit breaker is closed. It keeps continously monitoring the number of failures occurring withing the configured time period. Its state will change to Open, if the failure rate exceeds the specified threshold. If not, it will reset the failure count and timeout period

### Open
Circuit breaker will block the interaction between microservices during Open state. Request will fail and exception will be thrown. It remains in Open state and change to Half Open after timeout.

### Half Open
Circuit breaker will allow limited number of requests to pass through. It switches to Open state if failure rate is greater than specified threshold otherwise to Closed state.
