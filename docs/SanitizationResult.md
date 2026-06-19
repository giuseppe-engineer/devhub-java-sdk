

# SanitizationResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**sanitized** | **String** |  |  [optional] |
|**contextApplied** | [**ContextAppliedEnum**](#ContextAppliedEnum) |  |  [optional] |
|**issuesDetected** | **List&lt;String&gt;** |  |  [optional] |
|**actionsApplied** | **List&lt;String&gt;** |  |  [optional] |
|**riskLevel** | **String** |  |  [optional] |
|**riskScore** | **Integer** |  |  [optional] |
|**explanations** | **List&lt;String&gt;** |  |  [optional] |



## Enum: ContextAppliedEnum

| Name | Value |
|---- | -----|
| HTML | &quot;HTML&quot; |
| JSON | &quot;JSON&quot; |
| CSV | &quot;CSV&quot; |
| LOG | &quot;LOG&quot; |



