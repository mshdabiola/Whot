package com.mshdabiola.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext,
) : IRootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()


    override val stack: Value<ChildStack<*, IRootComponent.RootScreen>>
        get() = _stack

    override fun navigateToDetail() {
        navigation.push(Config.Splash)
    }

    private val _stack = childStack(
        source = navigation,
        initialConfiguration = Config.Main,
        serializer = Config.serializer(),
        handleBackButton = true,
        childFactory = ::factory
    )

    @Serializable
    private sealed interface Config  {

        @Serializable
        data object Main : Config
        @Serializable
        data object Splash : Config

    }

    private fun factory(
        config: Config,
        componentContext: ComponentContext
    ): IRootComponent.RootScreen {
        return when (config) {
            is Config.Splash -> IRootComponent.RootScreen.DetailRootScreen(
                navigateToSplash(
                    componentContext
                )
            )

            is Config.Main -> IRootComponent.RootScreen.MainRootScreen(
                navigateToMain(
                    componentContext
                )
            )
        }
    }

    private fun navigateToMain(componentContext: ComponentContext): MainComponent {
        return MainComponent(componentContext)
    }

    private fun navigateToSplash(componentContext: ComponentContext): DetailComponent {
        return DetailComponent(
            componentContext,
            //  onSplashFinished = {navigation.replaceCurrent(Config.Main)}
        )
    }
}
