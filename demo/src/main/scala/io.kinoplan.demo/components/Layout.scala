package io.kinoplan.demo.components

import io.kinoplan.demo.router.AppRouter.Page
import io.kinoplan.scalajs.react.material.ui.core.styles.{Breakpoints, Theme, Transition}
import io.kinoplan.scalajs.react.material.ui.core.{AppBar, Badge, CssBaseline, Divider, Drawer, IconButton, ListItem, ListItemIcon, ListItemText, ListSubheader, MaterialList, Toolbar, Typography}
import io.kinoplan.scalajs.react.material.ui.icons._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.{Resolution, RouterCtl}
import japgolly.scalajs.react.vdom.all._
import scalacss.DevDefaults._
import scalacss.ScalaCssReact._

object Layout {
  class LayoutStyle(theme: Theme = Theme.defaultTheme) extends StyleSheet.Inline {
    import dsl._

    private val drawerWidth = 240.px

    private val appBarTransition = theme.transitions.create(
      animatedProps = List("width", "margin"),
      easingValue = Transition.easing.sharp,
      durationValue = Transition.duration.leavingScreen
    )

    private val appBarShiftTransition = theme.transitions.create(
      animatedProps = List("width", "margin"),
      easingValue = Transition.easing.sharp,
      durationValue = Transition.duration.enteringScreen
    )

    private val drawerPaperTransition = theme.transitions.create(
      animatedProps = List("width"),
      easingValue = Transition.easing.sharp,
      durationValue = Transition.duration.enteringScreen
    )

    private val drawerPaperCloseTransition = theme.transitions.create(
      animatedProps = List("width"),
      easingValue = Transition.easing.sharp,
      durationValue = Transition.duration.leavingScreen
    )

    val root = style(
      display.flex
    )

    val toolbar = style(
      paddingRight(24.px)
    )

    val toolbarIcon = style(
      display.flex,
      alignItems.center,
      justifyContent.flexEnd,
      padding(0.px, 8.px),
      theme.mixins.toolbar
    )

    val appBar = style(
      zIndex :=! (theme.zIndex.drawer + 1).px,
      appBarTransition
    )

    val appBarShift = style(
      marginLeft(drawerWidth),
      width :=! s"calc(100% - $drawerWidth)",
      appBarShiftTransition
    )

    val menuButton = style(
      marginLeft(12.px),
      marginRight(36.px)
    )

    val menuButtonHidden = style(
      display.none
    )

    val title = style(
      flexGrow :=! 1.px
    )

    val drawerPaper = style(
      position.relative,
      whiteSpace.nowrap,
      width(drawerWidth),
      drawerPaperTransition
    )

    val drawerPaperClose = style(
      overflowX.hidden,
      drawerPaperCloseTransition,
      width(theme.spacing(7).px),
      theme.breakpoints.up(Breakpoints.sm)(
        width(theme.spacing(9).px)
      )
    )

    val appBarSpacer = theme.mixins.toolbar

    val content = style(
      flexGrow :=! 1.px,
      padding(theme.spacing(3).px),
      height(100.vh),
      overflow.auto
    )

    val chartContainer = style(
      marginLeft(-22.px)
    )

    val tableContainer = style(
      height(320.px)
    )

    val h5 = style(
      marginBottom(theme.spacing(2).px)
    )

    val emptyStyle = style()
  }

  case class Props(router: RouterCtl[Page], r: Resolution[Page], style: LayoutStyle)

  case class State(open: Boolean = true) {
    def handleDrawerOpen = copy(open = true)
    def handleDrawerClose = copy(open = false)
  }

  class Backend(t: BackendScope[Props, State]) {
    def handleDrawerOpen = t.modState(_.handleDrawerOpen)

    def handleDrawerClose = t.modState(_.handleDrawerClose)

    def render(props: Props, state: State) = {
      val classes = props.style

      div(classes.root,
        CssBaseline(),
        AppBar(position = AppBar.Position.absolute)(classes.appBar,
          Toolbar(disableGutters = !state.open)(classes.toolbar,
            IconButton(color = IconButton.Color.inherit)(classes.menuButton + (if (state.open) classes.menuButtonHidden else classes.emptyStyle),
              aria.label := "Open drawer",
              onClick --> handleDrawerOpen,
              Menu()
            ),
            Typography(
              component = Some("h1"),
              variant = Typography.Variant.h6,
              color = Typography.Color.inherit,
              noWrap = true
            )(classes.title,
              "Dashboard"
            ),
            IconButton(color = IconButton.Color.inherit)(
              Badge(badgeContent = Some(VdomNode(4)), color = Badge.Color.secondary)(
                Notifications()
              )
            )
          )
        ),
        Drawer(variant = Drawer.Variant.permanent, open = state.open)(classes.drawerPaper + (if(!state.open) classes.drawerPaperClose else classes.emptyStyle),
          div(classes.toolbarIcon,
            IconButton()(onClick --> handleDrawerClose,
              ChevronLeft()
            )
          ),
          Divider(),
          MaterialList()(
            div(
              ListItem(button = true)(
                ListItemIcon()(
                  Dashboard()
                ),
                ListItemText(primary = Some(VdomNode("Dashboard")))()
              ),
              ListItem(button = true)(
                ListItemIcon()(
                  ShoppingCart()
                ),
                ListItemText(primary = Some(VdomNode("Orders")))()
              ),
              ListItem(button = true)(
                ListItemIcon()(
                  People()
                ),
                ListItemText(primary = Some(VdomNode("Customers")))()
              ),
              ListItem(button = true)(
                ListItemIcon()(
                  BarChart()
                ),
                ListItemText(primary = Some(VdomNode("Reports")))()
              ),
              ListItem(button = true)(
                ListItemIcon()(
                  Layers()
                ),
                ListItemText(primary = Some(VdomNode("Integrations")))()
              )
            )
          ),
          Divider(),
          MaterialList()(
            div(
              ListSubheader(inset = true)("Saved reports"),
              ListItem(button = true)(
                ListItemIcon()(
                  Assignment()
                ),
                ListItemText(primary = Some(VdomNode("Current month")))()
              ),
              ListItem(button = true)(
                ListItemIcon()(
                  Assignment()
                ),
                ListItemText(primary = Some(VdomNode("Last quarter")))()
              ),
              ListItem(button = true)(
                ListItemIcon()(
                  Assignment()
                ),
                ListItemText(primary = Some(VdomNode("Year-end sale")))()
              )
            )
          )
        ),
        main(classes.content,
          div(classes.appBarSpacer,
            Typography(variant = Typography.Variant.h4, gutterBottom = true, component = Some("h2"))(
              "Orders"
            ),
            Typography(component = Some("div"))(classes.chartContainer,
              "SimpleLineChart"
            ),
            Typography(variant = Typography.Variant.h4, gutterBottom = true, component = Some("h2"))(
              "Products"
            ),
            div(classes.tableContainer,
              "SimpleTable"
            ),
            props.r.render()
          )
        )
      )
    }
  }

  object DefaultStyle extends LayoutStyle

  private val component = ScalaComponent.builder[Props]("Layout")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(router: RouterCtl[Page], r: Resolution[Page], style: LayoutStyle = DefaultStyle) = component(Props(router, r, style))
}
