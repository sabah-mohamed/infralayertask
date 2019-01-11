package com.projects.infralayertask

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "newsdetails")


internal class NewsFeed {
   /* var id: String? = null
    @Element(name = "itemId")*/

    @set:Element(name = "title")
    @get:Element var title: String? = null

    @set:Element(name = "imageUrl")
    @get:Element var url: String? = null

    @set:Element(name = "description")
    @get:Element var description: String? = null

    @set:Element(name = "category")
    @get:Element var category: String? = null

    @set:Element(name = "pubDate")
    @get:Element var pubDate: String? = null


}