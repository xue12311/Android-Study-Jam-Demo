---
title:  Jetpack Compose学习  AlertDialog
date: 2021-5-25 11:13:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- AlertDialog

### AlertDialog 提示框 简单使用

```kotlin

@Composable
fun AlertDialogSample() {
    MaterialTheme {
        Column(
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            val openDialog = remember {
                mutableStateOf(false)
            }
            Button(onClick = {
                openDialog.value = true
            }) {
                Text(text = "弹出提示框")
            }
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        // 当用户点击对话框以外的地方或者按下系统返回键将会执行的代码
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "提示框标题")
                    },
                    text = {
                        Text(text = "提示框内容")
                    },
                    confirmButton = {
                        Button(onClick = { openDialog.value = false }) {
                            Text(text = "确认按钮")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { openDialog.value = false }) {
                            Text(text = "取消按钮")
                        }
                    })
            }
        }
    }
}

```


```kotlin

    @Composable
    fun AlertDialogSample2() {
        MaterialTheme {
            Column(
                Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                val openDialog = remember {
                    mutableStateOf(false)
                }
                Button(onClick = {
                    openDialog.value = true
                }) {
                    Text(text = "弹出提示框")
                }
                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = {
                            // 当用户点击对话框以外的地方或者按下系统返回键将会执行的代码
                            openDialog.value = false
                        },
                        title = {
                            Text(
                                text = "开启位置服务",
                                fontWeight = FontWeight.W700,
                                style = MaterialTheme.typography.h6
                            )
                        },
                        text = {
                            Text(
                                text = "这将意味着，我们会给您提供精准的位置服务，并且您将接受关于您订阅的位置信息",
                                fontSize = 16.sp
                            )
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    openDialog.value = false
                                },
                            ) {
                                Text(
                                    "确认",
                                    fontWeight = FontWeight.W700,
                                    style = MaterialTheme.typography.button
                                )
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {
                                    openDialog.value = false
                                }
                            ) {
                                Text(
                                    "取消",
                                    fontWeight = FontWeight.W700,
                                    style = MaterialTheme.typography.button
                                )
                            }
                        })
                }
            }
        }
    }

```

```kotlin

  @Composable
    fun AlertDialogSample3() {
        MaterialTheme {
            Column(
                Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                val openDialog = remember {
                    mutableStateOf(false)
                }
                Button(onClick = {
                    openDialog.value = true
                }) {
                    Text(text = "弹出提示框")
                }
                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = {
                            openDialog.value = false
                        },
                        title = {
                            Text(
                                text = "开启位置服务",
                                fontWeight = FontWeight.W700,
                                style = MaterialTheme.typography.h6
                            )
                        },
                        text = {
                            Text(
                                text = "这将意味着，我们会给您提供精准的位置服务，并且您将接受关于您订阅的位置信息",
                                fontSize = 16.sp
                            )
                        },
                        buttons = {
                            Row(
                                modifier = Modifier.padding(all = 8.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Button(
                                    modifier = Modifier.fillMaxWidth(),
                                    onClick = { openDialog.value = false }
                                ) {
                                    Text("必须接受！")
                                }
                            }
                        }
                    )
                }
            }
        }
    }

```
