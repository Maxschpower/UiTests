package com.maxsch.uitests.screen

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import com.maxsch.presentation.launch.list.LaunchListFragment
import com.maxsch.uitests.R
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object LaunchListScreen : KScreen<LaunchListScreen>() {

    override val layoutId: Int
        get() = R.layout.fragment_launch_list
    override val viewClass: Class<*>
        get() = LaunchListFragment::class.java

    val recycler: KRecyclerView = KRecyclerView({
        withId(R.id.launchList)
    }, itemTypeBuilder = {
        itemType(LaunchListScreen::Item)
    })

    class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val title: KTextView = KTextView(parent) { withId(R.id.launchTitle) }
        val description: KTextView = KTextView(parent) { withId(R.id.launchDescription) }
    }
}