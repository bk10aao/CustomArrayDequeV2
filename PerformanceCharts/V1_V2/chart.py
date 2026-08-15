import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.lines import Line2D

# Load datasets
v1_df = pd.read_csv('CustomArrayDequeV1_jmh_performance_pivoted.csv', sep=';')
v2_df = pd.read_csv('CustomArrayDequeV2_jmh_performance_pivoted.csv', sep=';')

# Get common columns excluding 'Size'
common_cols = sorted([
    col for col in v1_df.columns
    if col in v2_df.columns and col != 'Size'
])

# Filter for methods with valid data
valid_cols = [
    col for col in common_cols
    if pd.notna(v1_df[col].mean()) and pd.notna(v2_df[col].mean())
]

# Define specific colors
color_v1 = '#ff4d4d'  # Red
color_v2 = '#4da6ff'  # Blue

# Generate a plot for each valid method
for method in valid_cols:
    fig, ax = plt.subplots(figsize=(8, 5.5))

    # Plot data
    ax.plot(v1_df['Size'], v1_df[method],
            color=color_v1, marker='o', markersize=5,
            linestyle='-', linewidth=2)
    ax.plot(v2_df['Size'], v2_df[method],
            color=color_v2, marker='o', markersize=5,
            linestyle='-', linewidth=2)

    # X-axis range exactly from 10,000 to 100,000
    ax.set_xlim(left=10000, right=100000)

    # White text for dark-mode compatibility
    ax.set_title(method, fontsize=14, fontweight='bold', color='white', pad=15)
    ax.set_xlabel('Size', fontsize=11, color='white')
    ax.set_ylabel('Time (ns)', fontsize=11, color='white')

    # Ticks and grid
    ax.tick_params(axis='both', colors='white')
    ax.grid(True, linestyle='--', alpha=0.3, color='white')

    # Axes borders
    for spine in ax.spines.values():
        spine.set_color('white')

    # Custom Legend
    legend_elements = [
        Line2D([0], [0], marker='o', color='none', label='V1',
               markerfacecolor=color_v1, markeredgecolor=color_v1,
               markersize=8, linestyle='None'),
        Line2D([0], [0], marker='o', color='none', label='V2',
               markerfacecolor=color_v2, markeredgecolor=color_v2,
               markersize=8, linestyle='None')
    ]

    legend = ax.legend(handles=legend_elements, loc='upper center',
                       bbox_to_anchor=(0.5, -0.15),
                       fontsize=10, frameon=False, ncol=2)
    for text in legend.get_texts():
        text.set_color('white')

    # Transparent background
    fig.patch.set_alpha(0.0)
    ax.patch.set_alpha(0.0)

    plt.tight_layout()

    # Sanitize the method name for the filename
    safe_filename = (method.replace('(', '_')
                           .replace(')', '_')
                           .replace(',', '_')
                           .replace('.', '_'))

    plt.savefig(f'plot_{safe_filename}.png', transparent=True, bbox_inches='tight')
    plt.close()

print(f"Successfully generated {len(valid_cols)} V1 vs V2 performance graphs with X-axis capped at 100,000.")