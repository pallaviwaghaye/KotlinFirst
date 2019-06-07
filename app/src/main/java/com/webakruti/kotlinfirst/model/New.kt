package com.webakruti.kotlinfirst.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class New {

    inner class Bar {

        @SerializedName("type")
        @Expose
        var type: String? = null

    }


    inner class Baz {

        @SerializedName("type")
        @Expose
        var type: String? = null

    }


    inner class Example {

        @SerializedName("type")
        @Expose
        var type: String? = null
        @SerializedName("properties")
        @Expose
        var properties: Properties? = null

    }


    inner class Foo {

        @SerializedName("type")
        @Expose
        var type: String? = null

    }


    inner class Properties {

        @SerializedName("foo")
        @Expose
        var foo: Foo? = null
        @SerializedName("bar")
        @Expose
        var bar: Bar? = null
        @SerializedName("baz")
        @Expose
        var baz: Baz? = null

    }
}
