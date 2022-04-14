# Background

Build a micro service that is functionally similar to this: https://file-metadata-microservice.freecodecamp.rocks/

# Kata Requirements

- You can submit a form that includes a file upload.
- The form file input field has the "name" attribute of "upfile".
- When you submit a file, you receive the
  - file name,
  - type,
  - size in bytes within the JSON response
- Example response

```json
{
  "name": "IMG_20200909_111104.jpg",
  "type": "image/jpeg",
  "size": 143898
}
```

# Plugin details

- atlas-run -- installs this plugin into the product and starts it on localhost
- atlas-debug -- same as atlas-run, but allows a debugger to attach at port 5005
- atlas-help -- prints description for all commands in the SDK

# Resources

- Servlet - https://developer.atlassian.com/server/jira/platform/servlet/
- Plugin SDK - https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK
- Save settings - https://developer.atlassian.com/server/framework/atlassian-sdk/sal-code-samples/
- Save data - https://developer.atlassian.com/server/framework/atlassian-sdk/store-and-retrieve-plugin-data/
- Original Free Code Camp project - https://www.freecodecamp.org/learn/back-end-development-and-apis/back-end-development-and-apis-projects/file-metadata-microservice
- Web resource contexts for bitbucket - https://developer.atlassian.com/server/bitbucket/reference/web-resource-contexts/
- Velocity Template - https://velocity.apache.org/engine/1.7/user-guide.html
**Troubleshooting**
- Autowire dependency required for using Velocity Template - https://community.developer.atlassian.com/t/this-is-not-allowed-when-atlassian-plugin-key-is-set/3117/3
