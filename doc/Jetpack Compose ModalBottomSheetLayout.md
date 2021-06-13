---
title:  Jetpack Compose学习  ModalBottomSheetLayout
date: 2021-5-27 11:13:12
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- ModalBottomSheetLayout 底部弹出布局

### ModalBottomSheetLayout 底部弹出布局 基本使用

```kotlin

@ExperimentalMaterialApi
@Composable
fun ComposableSample() {
    val state = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetContent = {
            Column {
                ListItem(
                    text = {
                        Text(text = "选择分享到哪里吧~")
                    }
                )
                ListItem(
                    text = {
                        Text(text = "github")
                    },
                    icon = {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF181717)
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_github),
                                null,
                                Modifier.padding(4.dp),
                                Color.White
                            )
                        }
                    }, modifier = Modifier.clickable { }
                )
                ListItem(
                    text = {
                        Text(text = "wechat")
                    },
                    icon = {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF181717)
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_wechat),
                                null,
                                Modifier.padding(4.dp),
                                Color.White
                            )
                        }
                    }, modifier = Modifier.clickable { }
                )
                ListItem(
                    text = {
                        Text(text = "twitter")
                    },
                    icon = {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF181717)
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_twitter),
                                null,
                                Modifier.padding(4.dp),
                                Color.White
                            )
                        }
                    }, modifier = Modifier.clickable { }
                )
            }
        },
        sheetState = state
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                scope.launch {
                    state.show()
                }
            }) {
                Text(text = "分享")
            }
        }
    }
    //返回键 处理  ModalBottomSheet 收回
    BackHandler(
        enabled = (state.currentValue == ModalBottomSheetValue.HalfExpanded ||
                state.currentValue == ModalBottomSheetValue.Expanded),
        onBack = {
            scope.launch {
                state.hide()
            }
        })
}

```

### 收回 ModalBottomSheet
一般情况下，ModalBottomSheet 无法自动处理按下返回键就收起，所以我们可以用 BackHandler 来处理
在 ModalBottomSheet 后添加代码:

```kotlin

BackHandler(
    enabled = (state.currentValue == ModalBottomSheetValue.HalfExpanded
            || state.currentValue == ModalBottomSheetValue.Expanded),
    onBack = {
        scope.launch{
            state.hide()
        }
    }
)

```
### 设置动画时间
ModalSheetLayout 默认用 state.show() 或者 state.hidden() 来弹出和收回
我们可以通过这样的方式来自定义动画时间:

```kotlin

state.animateTo(ModalBottomSheetValue.Hidden, tween(1000))

```
