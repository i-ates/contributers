# contributers

Simple API to get a repository top 10 contributers information.

serverUrl/api/contributers/top10/{organizationName}/{repositoryName}

http://localhost:8080/api/contributers/top10/apache/commons-lang
```json
[
{
"repo": "commons-lang",
"user": "garydgregory",
"location": "USA",
"company": "Apache Software Foundation",
"contributions": 1657
},
{
"repo": "commons-lang",
"user": "britter",
"location": "Neuss",
"company": "@gradle",
"contributions": 656
},
{
"repo": "commons-lang",
"user": "sebbASF",
"location": null,
"company": null,
"contributions": 501
},
{
"repo": "commons-lang",
"user": "PascalSchumacher",
"location": null,
"company": null,
"contributions": 263
},
{
"repo": "commons-lang",
"user": "mbenson",
"location": "Ashland City, TN USA",
"company": "Three's",
"contributions": 222
},
{
"repo": "commons-lang",
"user": "chtompki",
"location": "Richmond, VA",
"company": null,
"contributions": 90
},
{
"repo": "commons-lang",
"user": "dependabot[bot]",
"location": null,
"company": null,
"contributions": 88
},
{
"repo": "commons-lang",
"user": "mureinik",
"location": "Tel Aviv, Israel",
"company": "Synopsys",
"contributions": 77
},
{
"repo": "commons-lang",
"user": "dmjones",
"location": null,
"company": null,
"contributions": 61
},
{
"repo": "commons-lang",
"user": "chonton",
"location": "Mountain View, CA",
"company": "@proofpoint ",
"contributions": 58
}
]

```

## TODO
*Add http error handling
*Add unit tests
*Dockerize the api
