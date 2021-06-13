---
title:  Jetpack Compose学习 TextField 
date: 2021-5-25 11:28:10 
tags:
- android
- Jetpack Compose 
categories:
- android
- Jetpack

---

## Jetpack Compose学习 -------- TextField 输入框

### TextField 输入框 基本使用

```kotlin

@Composable
fun BaseTextFieldDemo() {
    val textState = rememberSaveable {
        mutableStateOf("")
    }
    Column {
        TextField(
            //文本框里的文本内容
            value = textState.value,
            //文本框输入内容时候的回调
            onValueChange = {
                textState.value = it
            })
        Text(text = "您输入的内容: ${textState.value}")
    }
}

```

```kotlin

@Composable
fun ComposableSample() {
    var phone = rememberSaveable {
        mutableStateOf("")
    }
    Column {
        TextField(
            //文本框里的文本内容
            value = phone.value,
            //文本框输入内容时候的回调
            onValueChange = {
                phone.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            //启用
            enabled = true,
            //只读
            readOnly = false,
            label = {
                Text(text = "手机号码")
            },
            //在没有输入内容的时候显示，类似于 hint
            placeholder = {
                Text(text = "请输入手机号码")
            },
            //显示在文本框左边的控件
            leadingIcon = {
                Icon(Icons.Default.Phone, null)
            },
            //显示在文本框末尾的控件
            trailingIcon = {
                Icon(Icons.Default.Cancel, null)
            },
            //当前文本字段 是否 为 错误的
            isError = false,
            //形状 圆角
            shape = RoundedCornerShape(5.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "您输入的内容: ${phone.value}")
    }
}

```

```kotlin

@Composable
fun TextFieldDemo() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        //单行
        singleLine = true
    )
}

```

```kotlin

@Composable
fun ComposableSample() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, null)
        },
    )
}


```

```kotlin

@Composable
fun ComposableSample() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        leadingIcon = {
            Text("联系人")
        },
    )
}

```

### TextField 输入和修改文字

```kotlin
   //TextField 输入和修改文字
@Composable
fun SimpleFilledTextFieldSample() {
    var text = remember { mutableStateOf("Hello") }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = {
            Text(text = "Label")
        }
    )
}


//轮廓样式 输入框
@Composable
fun SimpleOutlinedTextFieldSample() {
    var text = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = {
            Text(text = "Label")
        }
    )
}


//设置 TextField 样式
@Composable
fun StyledTextField() {
    var text = remember {
        mutableStateOf("Hello\nWorld\nInvisible")
    }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = {
            Text(text = "Enter text")
        },
        maxLines = 2,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}


//设置 TextField 格式
@Composable
fun PasswordTextField() {
    var password = rememberSaveable {
        mutableStateOf("")
    }
    TextField(
        value = password.value,
        onValueChange = {
            password.value = it
        },
        label = { Text(text = "Enter password") },
        //密码样式
        visualTransformation = PasswordVisualTransformation(),
        //设置键盘选项 密码
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

```

```kotlin

@Composable
fun ComposableSample() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, null)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF0079D3),
            backgroundColor = Color.Transparent
        )
    )
}

```

```kotlin

@Composable
fun textFieldColors(
    // 输入的文字颜色
    textColor: Color = LocalContentColor.current.copy(LocalContentAlpha.current),

    // 禁用 TextField 时，已有的文字颜色
    disabledTextColor: Color = textColor.copy(ContentAlpha.disabled),

    // 输入框的背景颜色，当设置为 Color.Transparent 时，将透明
    backgroundColor: Color = MaterialTheme.colors.onSurface.copy(alpha = BackgroundOpacity),

    // 输入框的光标颜色
    cursorColor: Color = MaterialTheme.colors.primary,

    // 当 TextField 的 isError 参数为 true 时，光标的颜色
    errorCursorColor: Color = MaterialTheme.colors.error,

    // 当输入框处于焦点时，底部指示器的颜色
    focusedIndicatorColor: Color = MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high),

    // 当输入框不处于焦点时，底部指示器的颜色
    unfocusedIndicatorColor: Color = MaterialTheme.colors.onSurface.copy(alpha = UnfocusedIndicatorLineOpacity),

    // 禁用 TextField 时，底部指示器的颜色
    disabledIndicatorColor: Color = unfocusedIndicatorColor.copy(alpha = ContentAlpha.disabled),

    // 当 TextField 的 isError 参数为 true 时，底部指示器的颜色
    errorIndicatorColor: Color = MaterialTheme.colors.error,

    // TextField 输入框前头的颜色
    leadingIconColor: Color = MaterialTheme.colors.onSurface.copy(alpha = IconOpacity),

    // 禁用 TextField 时 TextField 输入框前头的颜色
    disabledLeadingIconColor: Color = leadingIconColor.copy(alpha = ContentAlpha.disabled),

    // 当 TextField 的 isError 参数为 true 时 TextField 输入框前头的颜色
    errorLeadingIconColor: Color = leadingIconColor,

    // TextField 输入框尾部的颜色
    trailingIconColor: Color = MaterialTheme.colors.onSurface.copy(alpha = IconOpacity),

    // 禁用 TextField 时 TextField 输入框尾部的颜色
    disabledTrailingIconColor: Color = trailingIconColor.copy(alpha = ContentAlpha.disabled),

    // 当 TextField 的 isError 参数为 true 时 TextField 输入框尾部的颜色
    errorTrailingIconColor: Color = MaterialTheme.colors.error,

    // 当输入框处于焦点时，Label 的颜色
    focusedLabelColor: Color = MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high),

    // 当输入框不处于焦点时，Label 的颜色
    unfocusedLabelColor: Color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),

    // 禁用 TextField 时，Label 的颜色
    disabledLabelColor: Color = unfocusedLabelColor.copy(ContentAlpha.disabled),

    // 当 TextField 的 isError 参数为 true 时，Label 的颜色
    errorLabelColor: Color = MaterialTheme.colors.error,

    // Placeholder 的颜色
    placeholderColor: Color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),

    // 禁用 TextField 时，placeholder 的颜色
    disabledPlaceholderColor: Color = placeholderColor.copy(ContentAlpha.disabled)
)

```