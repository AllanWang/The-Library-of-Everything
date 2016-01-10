# The-Library-of-Everything

Bits and pieces to make adding small features easier.

To use the library, add the following to your gradle:

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

and then

```gradle
dependencies {
	...
    compile 'com.github.asdfasdfvful:The-Library-of-Everything:xxx@aar'
}
```

Where "xxx" represents the latest release tag