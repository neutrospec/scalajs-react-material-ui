package io.kinoplan.demo.components.demos.Cards

import io.kinoplan.demo.components.ComponentContainer
import io.kinoplan.demo.styles.demos.Cards.{DefaultMediaControlCardStyle, MediaControlCardStyle}
import io.kinoplan.scalajs.react.material.ui.core.styles.Direction
import io.kinoplan.scalajs.react.material.ui.core.{MuiCard, MuiCardContent, MuiCardMedia, MuiIconButton, MuiTypography}
import io.kinoplan.scalajs.react.material.ui.icons.{MuiPlayArrowIcon, MuiSkipNextIcon, MuiSkipPreviousIcon}
import japgolly.scalajs.react.vdom.all.{VdomElement, _}
import japgolly.scalajs.react.{BackendScope, ScalaComponent}
import scalacss.ScalaCssReact._

object MediaControlCard {
  case class Props(style: MediaControlCardStyle)

  class Backend(t: BackendScope[Props, Unit]) {
    def render(props: Props): VdomElement = {
      val css = props.style

      div(
        ComponentContainer("UI Controls")(
          MuiCard()(css.card,
            div(css.details,
              MuiCardContent()(css.content,
                MuiTypography(component = "h5", variant = MuiTypography.Variant.h5)(
                  "Live From Space"
                ),
                MuiTypography(variant = MuiTypography.Variant.subtitle1, color = MuiTypography.Color.textSecondary)(
                  "Mac Miller"
                )
              ),
              div(css.controls,
                MuiIconButton()(
                  aria.label := "Previous",
                  if (css.theme.direction == Direction.rtl.toString) MuiSkipNextIcon() else MuiSkipPreviousIcon()
                ),
                MuiIconButton()(
                  aria.label := "Play/pause",
                  MuiPlayArrowIcon()(css.playIcon)
                ),
                MuiIconButton()(
                  aria.label := "Next",
                  if (css.theme.direction == Direction.rtl.toString) MuiSkipPreviousIcon() else MuiSkipNextIcon()
                )
              )
            ),
            MuiCardMedia(
              image = Some("/static/images/cards/live-from-space.jpg")
            )(css.cover,
              title := "Live from space album cover"
            )
          )
        )
      )
    }
  }

  private val component = ScalaComponent.builder[Props]("MediaControlCard")
    .renderBackend[Backend]
    .build

  def apply(style: MediaControlCardStyle = DefaultMediaControlCardStyle) = component(Props(style))
}