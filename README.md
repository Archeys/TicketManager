# TicketManager
Basic ticket manager API in Java


# Requirements
- Java 8+
- Maven (latest preffered)

# API
- Run aplication by navigating to the root directory and running ```mvn spring-boot:run```
- API currently houses a single call - domain + /getTicketPricing.
- By default configured to port 8080 when ran on a local machine. (So - http://localhost:8080/getTicketPricing)

## Provide data as a JSON object to the API in the following format:

```
{
    "passengerList": [
        {
            "passengerType": "ADULT",
            "bagCount": 2
        },
        {
            "passengerType": "CHILD",
            "bagCount": 1
        }
    ]
}
```

### Contraints
- Passenger type must be either "ADULT" or "CHILD"
- Bag count must not be lower than 0
