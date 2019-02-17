package io.kinoplan.scalajs.react.material.ui.core

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object AppBar extends ReactBridgeComponent with AppBarExtensions {
  override protected lazy val componentValue: js.Function = RawComponent

  @JSImport("@material-ui/core", "AppBar")
  @js.native
  object RawComponent extends js.Function

  def apply(
    classes: js.Object = js.Object(),
    color: Color.Value = Color.primary,
    position: Position.Value = Position.fixed
  ): WithProps = auto
}

trait AppBarExtensions {
  object Color extends Enumeration {
    val inherit = Value("inherit")
    val primary = Value("primary")
    val secondary = Value("secondary")
    val default = Value("default")
  }

  object Position extends Enumeration {
    val fixed = Value("fixed")
    val absolute = Value("absolute")
    val sticky = Value("sticky")
    val static = Value("static")
    val relative = Value("relative")
  }
}