---
title:  Jetpack Compose学习 Image Icon 
date: 2021-5-25 11:22:10 
tags:
- android
- Jetpack Compose 
categories:
- android
- Jetpack

---

## Jetpack Compose学习 -------- 图片 Image , Icon

### Image 图片 基本使用

```kotlin

@Composable
fun ImageResourceDemo() {
    val image = painterResource(id = R.mipmap.icon_header)
    Column {
        Image(
            painter = image,
            contentDescription = "图片描述"
        )
        Image(
            painter = image,
            contentDescription = "图片描述",
            //设置图片大小
            modifier = Modifier.size(100.dp)
        )
        Surface( 
            //设置形状
            shape = CircleShape
        ) {
            Image(
                painter = image,
                contentDescription = "图片描述",
                //设置图片大小
                modifier = Modifier.size(100.dp),
                //保持宽高比缩放
                contentScale = ContentScale.Crop
            )
        }

        Surface(
            //设置形状
            shape = CircleShape,
            //边框
            border = BorderStroke(2.dp, Color.Gray),
        ) {
            Image(
                painter = image,
                contentDescription = "图片描述",
                //设置图片大小
                modifier = Modifier.size(100.dp),
                //保持宽高比缩放
                contentScale = ContentScale.Crop
            )
        }
    }
}

```

### 图片加载

```kotlin
    //图片加载    
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    implementation("com.google.accompanist:accompanist-glide:0.10.0")
```

```kotlin

import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun ComposableSample() {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val str_img_url by remember {
            mutableStateOf(
                "https://tenfei04.cfp.cn/creative/vcg/veer/800water/veer-170860698.jpg"
            )
        }
        Image(
            painter = rememberGlidePainter(
                request = str_img_url,
                //占位图片
                previewPlaceholder = R.mipmap.ic_launcher,
            ),
            null,
            Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = rememberGlidePainter(
            request = str_img_url,
            requestBuilder = {
                //圆形
                transform(CircleCrop())
            }
        ), contentDescription = null,
            Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = rememberGlidePainter(
            request = str_img_url,
            requestBuilder = {
                //圆角
                transform(RoundedCorners(20))
            }
        ), contentDescription = null,
            Modifier.size(100.dp)
        )
    }
}

```
### 自定义控件
```kotlin

    @Composable
    fun ComposableSample() {
        val painter =
            rememberGlidePainter(
                request = "https://tva1.sinaimg.cn/large/a15b4afegy1fmvjlgdxxgj21hc0u04qp.jpg"
            )
        Box(Modifier.fillMaxSize()) {
            Image(
                painter = painter,
                contentDescription = null,
                //居中
                Modifier.align(Alignment.Center)
            )
            //加载状态
            when (painter.loadState) {
                //加载中
                is ImageLoadState.Loading -> {
                    //圆形进度条
                    CircularProgressIndicator(
                        //居中
                        Modifier.align(Alignment.Center)
                    )
                    Snackbar {
                        Text(text = "图片加载中")
                    }
                }
                //加载失败
                is ImageLoadState.Error -> {
                    Snackbar {
                        Text(text = "图片加载失败")
                    }
                }
                //加载成功
                is ImageLoadState.Success -> {
                    Snackbar {
                        Text(text = "图片加载成功")
                    }
                }

            }
        }
    }

```

### Icon 基本使用

```kotlin

@Composable
fun ComposableSample() {
    Row {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.Gray)
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.Red)
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.DarkGray)
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.Magenta)
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.Cyan)
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.Blue)
    }
}

```
