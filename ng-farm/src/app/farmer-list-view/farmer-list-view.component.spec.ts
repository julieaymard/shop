import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmerListViewComponent } from './farmer-list-view.component';

describe('FarmerListViewComponent', () => {
  let component: FarmerListViewComponent;
  let fixture: ComponentFixture<FarmerListViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FarmerListViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmerListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
