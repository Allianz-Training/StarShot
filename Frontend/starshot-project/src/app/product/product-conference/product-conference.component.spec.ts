import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductConferenceComponent } from './product-conference.component';

describe('ProductConferenceComponent', () => {
  let component: ProductConferenceComponent;
  let fixture: ComponentFixture<ProductConferenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductConferenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductConferenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
