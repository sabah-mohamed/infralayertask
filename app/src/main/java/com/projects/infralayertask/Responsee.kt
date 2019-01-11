package com.projects.infralayertask

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "News", strict = false)

class Responsee {
    @ElementList(inline = true)
    internal var news: List<NewsFeed>? = null
}