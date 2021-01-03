import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductMusicComponent } from './product-music.component';

describe('ProductMusicComponent', () => {
  let component: ProductMusicComponent;
  let fixture: ComponentFixture<ProductMusicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductMusicComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductMusicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
