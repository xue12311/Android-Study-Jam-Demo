---
title:  Jetpack Compose学习  AnimationVisibility
date: 2021-5-27 14:51:03
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- AnimationVisibility

### AnimationVisibility 动画 可见 基础用法

```kotlin

@ExperimentalAnimationApi
@Composable
fun ComposableSample() {
    var state by remember {
        mutableStateOf(true)
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = state) {
            Text(
                text = "这是一个普通的正文",
                fontWeight = FontWeight.W900,
                style = MaterialTheme.typography.h5
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { state = !state }) {
            Text(
                text = if (state) {
                    "隐藏"
                } else {
                    "显示"
                }
            )
        }
    }
}

```

### 进场动画
```kotlin

@ExperimentalAnimationApi
@Composable
fun ComposableSample() {
    var state by remember { mutableStateOf(true) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = state,
            enter = slideInVertically(
                //初始位置 Y轴
                initialOffsetY = { -1000 },
                animationSpec = tween(
                    //动画持续时间
                    durationMillis = 1200
                )
            )
        ) {
            Text(
                text = "这是一个普通的正文",
                fontWeight = FontWeight.W900,
                style = MaterialTheme.typography.h5
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { state = !state }) {
            Text(
                text = if (state) {
                    "隐藏"
                } else {
                    "显示"
                }
            )
        }
    }
}

```

```kotlin

    @ExperimentalAnimationApi
    @Composable
    fun ComposableSample() {
        var state by remember { mutableStateOf(true) }
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(
                visible = state,
                //垂直滑入
                enter = slideInVertically(
                    //初始位置 Y轴
                    initialOffsetY = { -1000 },
                    animationSpec = tween(
                        //动画持续时间
                        durationMillis = 1200
                    )
                    //淡入
                ) + fadeIn(
                    animationSpec = tween(
                        //动画持续时间
                        durationMillis = 1200
                    )
                )
            ) {
                Text(
                    text = "这是一个普通的正文",
                    fontWeight = FontWeight.W900,
                    style = MaterialTheme.typography.h5
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = { state = !state }) {
                Text(
                    text = if (state) {
                        "隐藏"
                    } else {
                        "显示"
                    }
                )
            }
        }
    }

```
