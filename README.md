# Talking Clock Application

## Overview
Within the team, we don't like clocks that display as numbers. In fact, we like clocks that present the current time in a more "Human Friendly" way.

## Example
01:00 One o'clock
02:00 Two o'clock
13:00 One o'clock
13:05 Five past one
13:10 Ten past one
13:25 Twenty five past one
13:30 Half past one
13:35 Twenty five to two
13:55 Five to two

For example, if we execute this program at 16:30, it should output "Half past four"

## Guidelines
1. Command line (Without argument)
   
   Main.java

   $ talking-clock

   Half past four 

2. Command line (With argument)

   Main.java

   $ talking-clock 15:00

   Three o'clock 

3. API call

   Application.java

    GET /talking-clock?time=16:15


    Request parameter:

    time [String], Optional

    EG: 16:15

Sample Response:

HTTP Status: 200
```json
   {
      "time": "01:15",
      "talkTime": "Quarter past one"
   }
```

Sample Error Response:
HTTP Status: 400
```json
   {
   "time": "1:15",
   "talkTime": "Your clock is malfunctioning!"
}
```

HTTP Status: 400
```json
   {
      "time": "Thank you for checking my program :)",
      "talkTime": "Your clock is malfunctioning!"
   }
```
