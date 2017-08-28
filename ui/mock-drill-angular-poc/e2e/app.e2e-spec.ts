import { MockDrillAngularPocPage } from './app.po';

describe('mock-drill-angular-poc App', function() {
  let page: MockDrillAngularPocPage;

  beforeEach(() => {
    page = new MockDrillAngularPocPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
