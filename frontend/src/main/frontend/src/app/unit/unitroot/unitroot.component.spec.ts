import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitrootComponent } from './unitroot.component';

describe('UnitrootComponent', () => {
  let component: UnitrootComponent;
  let fixture: ComponentFixture<UnitrootComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnitrootComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnitrootComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
