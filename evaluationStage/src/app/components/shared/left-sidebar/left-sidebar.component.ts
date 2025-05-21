import { CommonModule } from '@angular/common';
import { Component, input, output } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-left-sidebar',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './left-sidebar.component.html',
  styleUrl: './left-sidebar.component.css',
})
export class LeftSidebarComponent {
  isLeftSidebarCollapsed = input.required<boolean>();
  changeIsLeftSidebarCollapsed = output<boolean>();
  items = [
    {
      routeLink: 'home',
      icon: 'fal fa-home',
      label: 'Accueil',
    },
    {
      routeLink: 'tuteur',
      icon: 'fal fa-user-tie',
      label: 'Tuteurs',
    },
    {
      routeLink: 'stagiaire',
      icon: 'fal fa-briefcase',
      label: 'Stages',
    },
    {
      routeLink: 'stage',
      icon: 'fal fa-user-graduate',
      label: 'Stagiaires',
    },
    // {
    //   routeLink: 'settings',
    //   icon: 'fal fa-cog',
    //   label: 'Settings',
    // },
  ];

  toggleCollapse(): void {
    this.changeIsLeftSidebarCollapsed.emit(!this.isLeftSidebarCollapsed());
  }

  closeSidenav(): void {
    this.changeIsLeftSidebarCollapsed.emit(true);
  }
}
