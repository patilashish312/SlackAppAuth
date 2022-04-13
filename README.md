#### SlackAppAuth

- This is Simple Slack App auth utility which will tell us how to use Slack Bot Java API.
- Here in this utility, we need to have workspace available where we can create Slack APP. Details can be found under https://api.slack.com/start/building
- Once slack App is created & linked to workspace; we can add more extra features like enabling authorization so that only users / channels which valid token can able to access this APP.
- For this we need to enable `Socket Mode` so that we can use token.
- If created slack app is command based slack app, then we can create App level token. Generate token will look like `xapp-**`. We can give different scopes to this token e.g. `connections:write , authorization:read`.
- Under `OAuth & Permissions` section we can generate Bot User OAuth Token. This token starts with `xoxb-*`.
- By this way we have generated 2 tokens which can be used by our utility code. 
- Set 2 environment variables namely `SLACK_APP_TOKEN` & `SLACK_BOT_TOKEN` probably under environment variables to set section in editor :
![image](https://user-images.githubusercontent.com/35179165/163179607-01767eb4-c480-4b28-a635-89a84aea918e.png)

- We have created one sample slack App which will return you simple `:wave: Hello`.
- Start code & go to slack channel. Put command  `/testcommand` & since we are using proper authorization we will correct response back from our code. Here simple `:wava: Hello`
- Flow works like below :
   a. Slack channel accepts command & then checks if there is socket mode enabled. 
   b. If its enabled then it checks if there is any hook (in this case our code) avaiable to verify authorization is correct.
   c. Once authorization passes, code can do further processing like responding back with sample text message, doing any `POST` operation with any other external URL, fetching data from secure database etc.

- Once you start application typical log looks like below:

   ` {"ok":true,"url":"https:\/\/*.slack.com\/","team":"Your Team","user":"cbot","team_id":"team id","user_id":"userid","bot_id":"botid","is_enterprise_install":false}

     13:21:57.867 [main] DEBUG com.slack.api.methods.impl.TeamIdCache - Created cache for an auth.test API call (token: xoxb-*..., team_id: teamid)
     13:21:57.984 [main] DEBUG com.slack.api.util.http.listener.DetailedLoggingListener - 
     [Request URL]
     POST https://slack.com/api/auth.test
     [Specified Request Headers]
     Authorization: (redacted) 
     User-Agent: Java-Slack-SDK; slack-api-client/1.21.1; OpenJDK 64-Bit Server VM/11; Windows 10/10.0; bolt/1.21.1;
     [Request Body]


     Content-Type: application/x-www-form-urlencoded
     Content Length: 0

     [Response Status]
     200 `


