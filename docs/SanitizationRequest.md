

# SanitizationRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**input** | **String** |  |  [optional] |
|**context** | **String** |  |  [optional] |
|**mode** | **String** |  |  [optional] |
|**operations** | [**List&lt;OperationsEnum&gt;**](#List&lt;OperationsEnum&gt;) |  |  [optional] |



## Enum: List&lt;OperationsEnum&gt;

| Name | Value |
|---- | -----|
| NONE | &quot;NONE&quot; |
| NORMALIZE_WHITESPACE | &quot;NORMALIZE_WHITESPACE&quot; |
| LOWERCASE | &quot;LOWERCASE&quot; |
| REMOVE_ACCENTS | &quot;REMOVE_ACCENTS&quot; |
| REMOVE_PII | &quot;REMOVE_PII&quot; |



