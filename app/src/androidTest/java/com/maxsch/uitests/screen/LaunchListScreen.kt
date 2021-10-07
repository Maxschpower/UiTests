package com.maxsch.uitests.screen

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import com.maxsch.presentation.launch.list.LaunchListFragment
import com.maxsch.uitests.R
import com.maxsch.uitests.view.KLaunchDescriptionView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
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
        val description: KLaunchDescriptionView = KLaunchDescriptionView(parent) {
            withId(R.id.launchDescriptionView)
        }
    }
}