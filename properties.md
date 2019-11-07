Properties
---

Key | Posibble Value | Description
----|:--------------:|------------
spring.jpa.hibernate.ddl-auto|none \| update \| validate \| create| Action took after deploy
spring.datasource.url|jdbc:mysql://host:port/database| Connection to database
spring.datasource.username|username| Username for connecting to database
spring.datasource.password|password| Password for connecting to database
cloud.aws.region.static|eu-center-1a| Used to automatically put the region, since we do not need an EC2 instance
cloud.aws.stack.auto| true \| false | 
spring.jackson.serialization.indent-output| true| set for how the JSON responses are indented