Deprecated
==========
This project will no more be maintained. You should rely on [AndroidSwipeLayout](https://github.com/daimajia/AndroidSwipeLayout) to implement such behaviour.

Disclaimer
==========
This project is a fork from [the swipelistview lib from 47deg](https://github.com/47deg/android-swipelistview).
The main project is still maintained so I recommend to use the main project since I forked this one to do modifications which can not be merged
with the main project, like heavy change in API.


SwipeListView
=============

An Android List View implementation with support for drawable cells and many other swipe related features.


Setup
=====

*Gradle*

```groovy

repositories {
        url 'https://oss.sonatype.org/content/groups/public/'
}

dependencies {
    compile 'com.vincentbrison.openlibraries.android:swipelistview:1.0.0-SNAPSHOT@jar'
}

```

Demo
====

You can use the devmodule from the project as a demo.


XML Usage
=========

If you decide to use SwipeListView as a view, you can define it in your xml layout like this:

```xml
    <com.fortysevendeg.swipelistview.SwipeListView
            xmlns:swipe="http://schemas.android.com/apk/res-auto"
            android:id="@+id/example_lv_list"
            android:listSelector="#00000000"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            swipe:swipeFrontView="@+id/front"
            swipe:swipeBackView="@+id/back"
            swipe:swipeActionLeft="[reveal | dismiss]"
            swipe:swipeActionRight="[reveal | dismiss]"
            swipe:swipeMode="[none | both | right | left]"
            swipe:swipeCloseAllItemsWhenMoveList="[true | false]"
            swipe:swipeOpenOnLongPress="[true | false]"
            swipe:swipeAnimationTime="[miliseconds]"
            swipe:swipeOffsetLeft="[dimension]"
            swipe:swipeOffsetRight="[dimension]"
            />
```

* `swipeFrontView` - **Required** - front view id.
* `swipeBackView` - **Required** - back view id.
* `swipeActionLeft` - Optional - left swipe action Default: 'reveal'
* `swipeActionRight` - Optional - right swipe action Default: 'reveal'
* `swipeMode` - Gestures to enable or 'none'. Default: 'both'
* `swipeCloseAllItemsWhenMoveList` - Close revealed items on list motion. Default: 'true'
* `swipeOpenOnLongPress` - Reveal on long press Default: 'true'
* `swipeAnimationTime` - item drop animation time. Default: android configuration
* `swipeOffsetLeft` - left offset
* `swipeOffsetRight` - right offset

License
=======

    Copyright 2013 Vincent Brison.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    Copyright (C) 2012 47 Degrees, LLC
    http://47deg.com
    hello@47deg.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

