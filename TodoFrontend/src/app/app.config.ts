import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [provideHttpClient() ,provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes)]
  //It enables HTTP services in an Angular application by providing the HttpClient service globally
};
