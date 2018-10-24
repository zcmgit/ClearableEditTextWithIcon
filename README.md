自定义带删除图标的Edittext

引用:

implementation 'com.github.zcmgit:ClearableEditTextWithIcon:v1.1'

maven { url 'https://jitpack.io' }

<com.example.edittext.weigets.ClearableEditTextWithIcon
        android:layout_width="match_parent"
        android:layout_height="40dp"
        app:icon="@mipmap/clean_icon"
        android:layout_marginTop="20dp"/>
        
        app:icon设置删除图标，默认为clean_icon
