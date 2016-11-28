# =========CASE1 配置一个最简单的transition========
## State
    创建;修改
## Transition
    创建-》修改
## Event
    编辑
## Action
    执行修改操作

# =========CASE2 配置一个定时的transition========
## State
    活动创建;活动未开始
## Transition
    活动创建-》活动未开始,同时未开始的活动会自动执行job,到点上线
## Event
    发布
## Action
    未开始的活动自动上线