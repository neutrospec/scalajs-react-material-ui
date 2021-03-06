package io.kinoplan.scalajs.react.material.ui.core

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object MuiTableRow extends ReactBridgeComponent with MuiTableRowExtensions {
  override protected lazy val componentValue: js.Function = RawComponent

  @JSImport("@material-ui/core", "TableRow")
  @js.native
  object RawComponent extends js.Function

  def apply(
    classes: js.UndefOr[Map[ClassKey.Value, String]] = js.undefined,
    component: OptComponentPropType = js.undefined,
    hover: js.UndefOr[Boolean] = js.undefined
  ): WithProps = auto
}

trait MuiTableRowExtensions {
  object ClassKey extends Enumeration {
    type Value = String

    val root = "root"
    val selected = "selected"
    val hover = "hover"
    val head = "head"
    val footer = "footer"
  }
}
