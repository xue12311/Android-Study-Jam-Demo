---
title:  Jetpack Compose学习  Column Row Box Spacer BoxWithConstraints ConstraintLayout 
date: 2021-5-25 11:19:10
tags:
  - android
  -  Jetpack Compose
categories: 
  - android
  - Jetpack
---

## Jetpack Compose学习 -------- 布局 Column Row Box Spacer BoxWithConstraints ConstraintLayout

### Column 垂直布局（将多个项垂直地放置在屏幕上）

```kotlin
   @Composable
    fun ColumnLayoutDemo() {
        //垂直布局
        Column {
            Text(text = "Alfred Sisley")
            Text(text = "3 minutes ago")
        }
    }
```


```kotlin

    @Composable
    fun ComposableSample() {
        //文字居中
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("你好呀")
            Text("我正在使用 Android Studio")
            Text("现在是晚上")
        }
    }

```
```kotlin

    @Composable
    fun ComposableSample() {
        //特定文字居中
        Column(
            Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "夜色",
                //特定文字居中
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.W900
            )
            Text("今晚的夜色很不错，我和朋友走在河边的小路上，看到了很多美丽的风景")
        }
    }

```

### Row 水平布局 （将多个项水平地放置在屏幕上）

```kotlin
  @Composable
fun RowLayoutDemo() {
    //水平布局
    Row(verticalAlignment = Alignment.CenterVertically) {
        //图片
        Image(
            painter = painterResource(id = R.mipmap.icon_header),
            contentDescription = null
        )
        //垂直布局
        Column {
            Text(text = "Alfred Sisley")
            Text(text = "3 minutes ago")
        }
    }
}
```
```kotlin
  @Preview
    @Composable
    fun AlignInRowDemo() {
        Row(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Gray),
            //水平排列
            horizontalArrangement = Arrangement.End,
            //垂直排列
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(Modifier.size(50.dp).background(Color.Yellow))
            Box(Modifier.size(50.dp).background(Color.Blue))
        }
    }
    
```

```kotlin

    @Composable
    fun ComposableSample() {
        Row {
            Box(Modifier.size(40.dp).background(Color.Magenta))
            Box(Modifier.size(40.dp).background(Color.Yellow))
            Box(Modifier.size(40.dp).background(Color.Green))
        }
    }

```

```kotlin

    @Composable
    fun ComposableSample() {
        Row {
            Box(
                Modifier
                    .size(40.dp)
                    //权重
                    .weight(1f)
                    .background(Color.Magenta)
            )
            Box(
                Modifier
                    .size(40.dp)
                    .background(Color.Yellow))
            Box(
                Modifier
                    .size(40.dp)
                    //权重
                    .weight(1f)
                    .background(Color.Green))
        }
    }

```

### Box 水平布局 （将一个元素放在另一个元素上）

```kotlin
@Composable
    fun BoxLayoutDemo() {
        Box() {
            Text(text = "测试", color = Color.Blue, fontSize = 15.sp)
            Text(text = "测试", color = Color.Yellow, fontSize = 30.sp)
        }
    }
```

![](1.png)


### Spacer 空白布局

```kotlin

    @Composable
    fun ComposableSample() {
        Row {
            Box(
                Modifier
                    .size(100.dp)
                    .background(Color.Magenta)
            )
            //空白布局
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                Modifier
                    .size(100.dp)
                    .background(Color.Yellow)
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                Modifier
                    .size(100.dp)
                    .background(Color.Green)
            )
        }
    }

```

```kotlin

    @Composable
    fun ArtistCardDemo() {
        val padding = 16.dp
        Column(
            Modifier
                .clickable(onClick = {
                    Log.d("Clickable", " clicked.")
                })
                .padding(padding)
                .fillMaxWidth()
        ) {
            RowLayoutDemo()
            Spacer(Modifier.size(padding))
            Card(elevation = 4.dp) {
                Image(
                    painter = painterResource(id = R.mipmap.icon_header),
                    contentDescription = null
                )
            }
        }
    }

```

```kotlin

      //内边距
    @Composable
    fun PaddedComposableDemo() {
        Text(
            text="Hello World",
            modifier =
            //背景
            Modifier.background(Color.Green)
                //内边距
                .padding(20.dp))

    }

```


```kotlin

//设置尺寸
    @Composable
    fun SizedComposableDemo() {
        Box(
            //设置尺寸
            modifier = Modifier.size(100.dp, 100.dp)
                //背景
                .background(Color.Red))
    }
```

```kotlin
   @Composable
    fun FixedSizeComposableDemo() {
        Box(
            modifier =
            Modifier
                //设置尺寸
                .size(90.dp, 150.dp)
                //背景
                .background(Color.Blue)
        ) {
            //设置所需尺寸
            Box(
                Modifier
                    .requiredSize(120.dp, 120.dp)
                    //背景
                    .background(Color.Red)
            )
        }
    }

```


```kotlin
@Composable
fun FillSizeComposableDemo() {
    Box(
        Modifier
            //背景
            .background(Color.Green)
            //尺寸
            .size(50.dp)
            //内边距
            .padding(10.dp)
    ) {
        Box(
            Modifier
                //背景
                .background(Color.Blue)
                //填充 最大边距
                .fillMaxSize()
        )
    }
}
```

```kotlin
   @Composable
    fun MatchParentSizeComposable() {
        Box {
            Spacer(
                modifier = Modifier
                    // 仅在 Box 作用域内可用
                    .matchParentSize()
                    //Spacer 将占用父项允许的所有可用空间，反过来使父项展开并填满所有可用空间
//                    .fillMaxSize()
                    .background(Color.Green)
            )
            Text(text = "Hello World")
        }
    }
```
```kotlin
   //在文本基线上方添加内边距
    @Composable
    fun TextWithPaddingFromBaseline() {
        Box(modifier = Modifier.background(Color.Green)) {
            Text(
                text = "Hello World",
                modifier = Modifier
                    //在文本基线上方添加内边距
                    .paddingFromBaseline(top = 20.dp, bottom = 5.dp)
            )
        }
    }
```
```kotlin
    //偏移量
    @Composable
    fun OffsetComposable() {
        Box(
            modifier = Modifier
                .size(width = 160.dp, height = 80.dp)
                .background(Color.Blue)
        ) {
            Text(
                text = "Layout offset modifier sample",
                //偏移量
                Modifier.offset(x = 16.dp, y = 40.dp)
            )
        }
    }
```
```kotlin
    //自适应布局
    @Composable
    fun FlexibleComposable() {
        Row(Modifier.width(200.dp)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp)
                    .background(Color.Green)
            )
            Box(
                modifier = Modifier
                    .weight(3f)
                    .height(30.dp)
                    .background(Color.Red)
            )
        }
    }
```

### BoxWithConstraints
```kotlin
  //约束条件
    @Composable
    fun WithConstraintsComposable() {
    //约束条件
        BoxWithConstraints {
            Text("My minHeight is $minHeight while my maxWidth is $maxWidth")
        }
    }
```

```kotlin

@Composable
fun ComposableSample() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
        //内容的对齐方式
        contentAlignment = Alignment.TopStart,
        //是否将约束作用于 子 View 上
        propagateMinConstraints = true,
    ) {
        val itemW = 50.dp
        val spaceW = 2.dp
        val count = (maxWidth.value / (itemW.value + spaceW.value)).toInt()
        if (count > 0) {
            Row() {
                for (i in 0 until count) {
                    Box(
                        Modifier
                            .size(itemW, itemW)
                            .background(Color.Blue)
                    )
                    Spacer(Modifier.size(spaceW))
                }
            }
        }
    }
}

```

### ConstraintLayout 约束布局
```kotlin
    @Composable
    fun ConstraintLayoutDemo() {
        ConstraintLayout {
            //通过 createRefs() 或 createRefFor() 创建关联的引用
            val (text1,text2,text3) = createRefs()
            //使用 constrainAs() 修饰符提供的约束条件
            Text(text = "Text1", Modifier.constrainAs(text1) {
                //指定约束条件
                start.linkTo(text2.end)
            })
            Text(text = "Text2", Modifier.constrainAs(text2) {
                top.linkTo(text1.bottom)
            })
            Text(text = "This is a very long text", Modifier.constrainAs(text3) {
                start.linkTo(text2.end)
                top.linkTo(text2.bottom)
            })
        }
    }
```
