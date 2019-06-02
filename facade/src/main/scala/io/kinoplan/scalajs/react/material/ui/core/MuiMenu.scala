package io.kinoplan.scalajs.react.material.ui.core

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

object MuiMenu extends ReactBridgeComponent with MuiMenuExtensions {
  override protected lazy val componentValue: js.Function = RawComponent

  @JSImport("@material-ui/core", "Menu")
  @js.native
  object RawComponent extends js.Function

  def apply(
    anchorEl: Option[js.Object | js.Function] = None,
    classes: Map[ClassKey.ClassKey, String] = Map.empty,
    disableAutoFocusItem: Boolean = false,
    MenuListProps: js.Object = js.Object(),
    onClose: Option[js.Function] = None,
    onEnter: Option[js.Function] = None,
    onEntered: Option[js.Function] = None,
    onEntering: Option[js.Function] = None,
    onExit: Option[js.Function] = None,
    onExited: Option[js.Function] = None,
    onExiting: Option[js.Function] = None,
    open: Boolean,
    PopoverClasses: js.Object = js.Object(),
    transitionDuration: Int | js.Object | TransitionDuration.Value = TransitionDuration.auto
  ): WithProps = auto
}

trait MuiMenuExtensions {
  object TransitionDuration extends Enumeration {
    val auto = Value("auto")
  }

  object ClassKey extends Enumeration {
    type ClassKey = String

    val paper = "paper"
  }
}